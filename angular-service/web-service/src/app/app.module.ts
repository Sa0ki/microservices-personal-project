import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule} from "@angular/common/http";
import { ContentsComponent } from './contents/get-contents/contents.component';
import { GraphQLModule } from './graphql.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AddContentComponent} from "./contents/add-content/add-content.component";
import {AddGenreComponent} from "./genres/add-genre/add-genre.component";
import {GetGenresComponent} from "./genres/get-genres/get-genres.component";

@NgModule({
  declarations: [
    AppComponent,
    ContentsComponent,
    AddContentComponent,
    GetGenresComponent,
    AddGenreComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    GraphQLModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
