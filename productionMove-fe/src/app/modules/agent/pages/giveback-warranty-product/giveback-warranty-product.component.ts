import { Component, OnInit } from '@angular/core';

interface Person {
    key: string;
    firstname: string;
    lastname: string;
    productline: string;
    error: string;
}
@Component({
  selector: 'app-giveback-warranty-product',
  templateUrl: './giveback-warranty-product.component.html',
  styleUrls: ['./giveback-warranty-product.component.less']
})


export class GivebackWarrantyProductComponent implements OnInit {

    constructor() {}

    ngOnInit(): void {
    }

    listOfData: Person[] = [
        {
            key: '1',
            firstname: 'Nguyễn Văn',
            lastname: 'Trường',
            productline: 'Sonata',
            error: 'Lỗi túi khí'
        },
        {
            key: '2',
            firstname: 'Nguyễn Văn',
            lastname: 'Trường',
            productline: 'Sonata',
            error: 'Lỗi túi khí'
        },
        {
            key: '3',
            firstname: 'Nguyễn Văn',
            lastname: 'Trường',
            productline: 'Sonata',
            error: 'Lỗi túi khí'
        }
    ];

}
