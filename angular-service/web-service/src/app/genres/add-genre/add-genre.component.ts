import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Apollo} from "apollo-angular";
import {GenreServiceService} from "../../services/genre-service/genre-service.service";
import {Router} from "@angular/router";
import {GenreForm} from "./genre.form";

@Component({
  selector: 'app-add-genre',
  templateUrl: './add-genre.component.html',
  styleUrls: ['./add-genre.component.css']
})
export class AddGenreComponent implements OnInit{
  contentForm: FormGroup;
  genre: any;
  constructor(private apollo: Apollo, private fb: FormBuilder,
              private genreService: GenreServiceService, private router: Router) {
  }
  ngOnInit(): void {
    this.initForm();
  }

  initForm(): void {
    this.contentForm = this.fb.group({
      name: ['', Validators.required]
    });
  }

  addGenre(): void {
    if(this.contentForm.valid){
      const formValue: GenreForm = this.contentForm.value;
      this.genreService.addGenre(formValue).subscribe(({data, loading}) => {
        this.genre = data;
        this.router.navigate(["genres"])
      });
    }
  }
}
