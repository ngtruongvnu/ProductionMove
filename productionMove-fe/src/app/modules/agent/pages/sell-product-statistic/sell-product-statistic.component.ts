import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import {ProductSelled} from "../../../../core/models/product-selled";

@Component({
  selector: 'app-sell-product-statistic',
  templateUrl: './sell-product-statistic.component.html',
  styleUrls: ['./sell-product-statistic.component.less']
})
export class SellProductStatisticComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

    listOfData: ProductSelled[] = [
        {
            name: 'Honda',
            quantityselled: 32,
            time: 'T1-2022'
        },
        {
            name: 'BMW',
            quantityselled: 32,
            time: 'T1-2022'
        },
        {
            name: 'John Brown',
            quantityselled: 32,
            time: 'T1-2022'
        }
    ];

  radioValue='A'
}
