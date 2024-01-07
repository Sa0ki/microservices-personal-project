import { Injectable } from '@angular/core';
import {GET_CONTENTS, POST_CONTENT} from "../graphql/content.queries.graphql";
import {Apollo} from "apollo-angular";
import {map, Observable, Subscription} from "rxjs";
import {ContentForm} from "../../contents/add-content/content.form";
@Injectable({
  providedIn: 'root'
})
export class ContentServiceService {
  constructor(private apollo: Apollo) { }
  getContent(): Observable<any> {
    return this.apollo.watchQuery<any>({
      query: GET_CONTENTS
    })
      .valueChanges.pipe(
        map(({loading, data}) => data.getContents)
      );
  }
  addContent(formValue: ContentForm): Observable<any> {
    return this.apollo.mutate({
      mutation: POST_CONTENT,
      variables: {
        title: formValue.title,
        year: formValue.year,
        image: "assets/" + formValue.image.split("\\")[2],
        genresIds: formValue.genresIds,
      },
    });
  }
}
