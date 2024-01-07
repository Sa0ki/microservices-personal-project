import {Component, OnInit} from '@angular/core';
import {ContentForm} from "./content.form";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Apollo} from "apollo-angular";
import {Router} from "@angular/router";
import {ContentServiceService} from "../../services/content-service/content-service.service";
import {GetGenresComponent} from "../../genres/get-genres/get-genres.component";
@Component({
  selector: 'app-add-content',
  templateUrl: './add-content.component.html',
  styleUrls: ['./add-content.component.css'],
})
export class AddContentComponent implements OnInit{
  loading: boolean;
  contentForm: FormGroup;
  genres: any;
  genresIds: any;
  constructor(private apollo: Apollo, private fb: FormBuilder,
              private router: Router, private contentService: ContentServiceService,
              public getGenresComponent: GetGenresComponent) {
  }
  ngOnInit(): void {
    this.getGenresComponent.getGenres();
    this.initForm();
  }
  initForm(): void {
    this.contentForm = this.fb.group({
      title: ['', Validators.required],
      year: [null, [Validators.required, Validators.min(1900), Validators.max(new Date().getFullYear())]],
      image: ['', Validators.required],
      genresIds: [],
    });
  }

  // Fonction pour ajouter du contenu
  addContent(): void {
    if (this.contentForm.valid) {
      var formValue: ContentForm = this.contentForm.value;
      this.contentService.addContent(formValue).subscribe(
        ({ data, loading }) => {
          this.loading = loading;
          console.log('Contenu ajouté avec succès:', data);
          this.contentForm.reset();
          this.router.navigate(["contents"]);
        },
        (error) => {
          console.error('Erreur lors de l\'ajout du contenu:', error);
        }
      );
    } else {
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
  handleFileInput(event: any): void {
    const file = event.target.files[0];
    this.contentForm.patchValue({ image: file });
    this.contentForm.get('image').updateValueAndValidity();
  }

}
