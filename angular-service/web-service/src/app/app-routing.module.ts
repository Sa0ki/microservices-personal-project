import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ContentsComponent} from "./contents/get-contents/contents.component";
import {AddContentComponent} from "./contents/add-content/add-content.component";
import {AddGenreComponent} from "./genres/add-genre/add-genre.component";
import {GetGenresComponent} from "./genres/get-genres/get-genres.component";

const routes: Routes = [
  {path: "contents", component: ContentsComponent},
  {path: "genres", component: GetGenresComponent},
  {path: "add-content", component: AddContentComponent},
  {path: "add-genre", component: AddGenreComponent},
  {path: "**", redirectTo: "", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
