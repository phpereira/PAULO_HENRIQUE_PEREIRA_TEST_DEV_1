import { Component, OnInit } from '@angular/core';
import { NitryxTestService } from '../nitryx-test.service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-nitryx-test',
  templateUrl: './nitryx-test.component.html',
  styleUrls: ['./nitryx-test.component.scss']
})
export class NitryxTestComponent implements OnInit {

  companies = []

  constructor(
    private nitryxService: NitryxTestService
  ) { }

  ngOnInit() {
  }

  listCompanies() {
    this.nitryxService.findAllCompanies().subscribe(
      response => {
        this.companies = response.map(company => ({
          id: company.id,
          name: company.name,
          segment: company.segment,
          sd: this.calculateStandardDeviation(company.stocks)
        }))
      })
  }

  calculateStandardDeviation(stock) {
    let pricesArray = []
    stock.forEach(stock => {
      pricesArray.push(stock.price)
    });

    var total = 0;
    for (var key in pricesArray)
      total += pricesArray[key];
    var meanVal = total / pricesArray.length;

    var SDprep = 0;
    for (var key in pricesArray)
      SDprep += Math.pow((parseFloat(pricesArray[key]) - meanVal), 2);
    var SDresult = Math.sqrt(SDprep / pricesArray.length);

    return SDresult
  }



}
