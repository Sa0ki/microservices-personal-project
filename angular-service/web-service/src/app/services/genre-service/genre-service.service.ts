import { Injectable } from '@angular/core';
import {Apollo} from "apollo-angular";
import {map, Observable} from "rxjs";
import {GET_GENRE, POST_GENRE} from "../graphql/genre.queries.graphql";
import {GenreForm} from "../../genres/add-genre/genre.form";

@Injectable({
  providedIn: 'root'
})
export class GenreServiceService {

  constructor(private apollo: Apollo) { }

  getGenres(): Observable<any> {
    return this.apollo.watchQuery<any>({
      query: GET_GENRE
    })
      .valueChanges.pipe(
        map(({loading, data}) => data.getGenresWithContents)
      );
  }
  addGenre(formValue: GenreForm): Observable<any> {
    return this.apollo.mutate({
      mutation: POST_GENRE,
      variables: {
        name: formValue.name
      }
    });
  }
}
