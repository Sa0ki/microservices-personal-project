import {Component, OnDestroy, OnInit} from '@angular/core';
import {Apollo} from "apollo-angular";
import {Subscription} from "rxjs";
import {GET_CONTENTS, POST_CONTENT} from "../graphql/queries.graphql";
import {ContentForm} from "./content.form";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-contents',
  templateUrl: './contents.component.html',
  styleUrls: ['./contents.component.css']
})
export class ContentsComponent implements OnInit, OnDestroy{
  loading: boolean;
  contents: any;
  private querySubscription: Subscription;
  contentForm: FormGroup;
  constructor(private apollo: Apollo, private fb: FormBuilder) {
  }
  ngOnInit(): void {
    this.getContents();
    this.initForm();
  }
  initForm(): void {
    this.contentForm = this.fb.group({
      title: ['', Validators.required],
      year: [null, [Validators.required, Validators.min(1900), Validators.max(new Date().getFullYear())]],
      image: ['', Validators.required],
      genresIds: [[]], // Vous pouvez ajouter des validateurs si nécessaire
    });
  }
  getContents(): void {
    this.querySubscription = this.apollo.watchQuery<any>({
      query: GET_CONTENTS
    })
      .valueChanges.subscribe(({data, loading}) => {
        this.loading = loading;
        this.contents = data.getContents;
      })
  }
  // Fonction pour ajouter du contenu
  addContent(): void {
    if (this.contentForm.valid) {
      const formValue: ContentForm = this.contentForm.value;

      this.apollo
        .mutate({
          mutation: POST_CONTENT,
          variables: {
            title: formValue.title,
            year: formValue.year,
            image: formValue.image,
            genresIds: formValue.genresIds,
          },
          refetchQueries: [{ query: GET_CONTENTS }],
        })
        .subscribe(
          ({ data, loading }) => {
            this.loading = loading;
            console.log('Contenu ajouté avec succès:', data);
            this.contentForm.reset(); // Réinitialisez le formulaire après l'ajout réussi
          },
          (error) => {
            console.error('Erreur lors de l\'ajout du contenu:', error);
          }
        );
    } else {
      // Marquez les champs du formulaire comme touchés pour afficher les erreurs
      this.markFormGroupTouched(this.contentForm);
    }
  }

  // Fonction pour marquer tous les champs d'un formulaire comme touchés
  markFormGroupTouched(formGroup: FormGroup): void {
    Object.values(formGroup.controls).forEach(control => {
      control.markAsTouched();

      if (control instanceof FormGroup) {
        this.markFormGroupTouched(control);
      }
    });
  }
  ngOnDestroy(): void {
    this.querySubscription.unsubscribe();
  }

}
