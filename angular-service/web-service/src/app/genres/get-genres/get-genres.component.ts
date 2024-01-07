import {Component, Injectable, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {GenreServiceService} from "../../services/genre-service/genre-service.service";

@Component({
  selector: 'app-get-genres',
  templateUrl: './get-genres.component.html',
  styleUrls: ['./get-genres.component.css']
})
@Injectable({
  providedIn: 'root',
})
export class GetGenresComponent implements OnInit, OnDestroy{
  genres: any;
  private querySubscription: Subscription;
  constructor(private genreService: GenreServiceService) {
  }
  ngOnInit(): void {
    this.getGenres();
  }
  getGenres() {
    this.querySubscription = this.genreService.getGenres().subscribe((data) => {
      this.genres = data;
    }, (error) => {
      console.error(error);
    })
  }
  ngOnDestroy(): void {
    this.querySubscription.unsubscribe();
  }
}
