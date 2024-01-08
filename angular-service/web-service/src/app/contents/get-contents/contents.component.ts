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
  searchTerm: string;
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
  async searchContent() {
    await this.getContents();
     this.contents = this.contents.filter((content) => {
      return content.title.toLowerCase().includes(this.searchTerm.toLowerCase());
    });
  }

  ngOnDestroy(): void {
    this.querySubscription.unsubscribe();
  }

}
