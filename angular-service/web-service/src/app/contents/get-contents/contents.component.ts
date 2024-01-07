import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {ContentServiceService} from "../../services/content-service/content-service.service";
@Component({
  selector: 'app-contents',
  templateUrl: './contents.component.html',
  styleUrls: ['./contents.component.css']
})
export class ContentsComponent implements OnInit, OnDestroy{
  contents: any;
  private querySubscription: Subscription;
  constructor(private contentService: ContentServiceService) {
  }
  ngOnInit(): void {
    this.getContents();
  }
  getContents(): void {
    this.querySubscription = this.contentService.getContent().subscribe(
      (data) => {
        this.contents = data;
      },
      (error) => {
        console.error(error);
      }
    );
  }
  ngOnDestroy(): void {
    this.querySubscription.unsubscribe();
  }

}
