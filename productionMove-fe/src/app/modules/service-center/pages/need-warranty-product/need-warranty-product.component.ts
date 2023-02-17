import { Component, OnInit } from '@angular/core';
import { NzTableFilterFn, NzTableFilterList, NzTableSortFn, NzTableSortOrder } from 'ng-zorro-antd/table'

interface DataItem {
    productline: string;
    productid: number;
    error: string;
}

interface ColumnItem {
    name: string;
    sortOrder: NzTableSortOrder | null;
    sortFn: NzTableSortFn<DataItem> | null;
    listOfFilter: NzTableFilterList;
    filterFn: NzTableFilterFn<DataItem> | null;
    filterMultiple: boolean;
    sortDirections: NzTableSortOrder[];
}

@Component({
  selector: 'app-need-warranty-product',
  templateUrl: './need-warranty-product.component.html',
  styleUrls: ['./need-warranty-product.component.less']
})
export class NeedWarrantyProductComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

    listOfColumns: ColumnItem[] = [
        {
            name: 'Productline',
            sortOrder: null,
            sortFn: (a: DataItem, b: DataItem) => a.productline.localeCompare(b.productline),
            sortDirections: ['ascend', 'descend', null],
            filterMultiple: true,
            listOfFilter: [
                { text: 'productline', value: 'productline' },
                { text: 'product', value: '', byDefault: true }
            ],
            filterFn: (list: string[], item: DataItem) => list.some(name => item.productline.indexOf(name) !== -1)
        },
        {
            name: 'ProductID',
            sortOrder: 'descend',
            sortFn: (a: DataItem, b: DataItem) => a.productid - b.productid,
            sortDirections: ['descend', null],
            listOfFilter: [],
            filterFn: null,
            filterMultiple: true
        },
        {
            name: 'Error',
            sortOrder: null,
            sortDirections: ['ascend', 'descend', null],
            sortFn: (a: DataItem, b: DataItem) => a.error.length - b.error.length,
            filterMultiple: false,
            listOfFilter: [
                { text: 'London', value: 'London' },
                { text: 'Sidney', value: 'Sidney' }
            ],
            filterFn: (address: string, item: DataItem) => item.error.indexOf(address) !== -1
        }
    ];
    listOfData: DataItem[] = [
        {
            productline: 'John Brown',
            productid: 32,
            error: 'New York No. 1 Lake Park'
        },
        {
            productline: 'Jim Green',
            productid: 42,
            error: 'London No. 1 Lake Park'
        },
        {
            productline: 'Joe Black',
            productid: 32,
            error: 'Sidney No. 1 Lake Park'
        },
        {
            productline: 'Jim Red',
            productid: 32,
            error: 'London No. 2 Lake Park'
        }
    ];
}
