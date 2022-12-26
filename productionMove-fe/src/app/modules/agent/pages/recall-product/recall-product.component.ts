import { Component, OnInit } from '@angular/core';
import { NzCascaderOption } from 'ng-zorro-antd/cascader';
import {ERRORS} from "../../../../core/constants/error";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-recall-product',
  templateUrl: './recall-product.component.html',
  styleUrls: ['./recall-product.component.less']
})
export class RecallProductComponent implements OnInit {

  constructor() {
  }
  ngOnInit(): void {
  }

    options = [
        { name: "SONATA", value: "SONATA" },
        { name: "ACCENT", value: "ACCENT" },
        { name: "PALISADE", value: "PALISADE" },
        { name: "MITSUBISHI XPANDER", value: "MITSUBISHI XPANDER" },
        { name: "NAVARA VL 4WD", value: "NAVARA VL 4WD" },
        { name: "NAVARA PRO-4X", value: "NAVARA PRO-4X" },
        { name: "HD36L", value: "HD36L" },
        { name: "XCIENT FUEL CELL", value: "XCIENT FUEL CELL" },
        { name: "UNIVERSE", value: "UNIVERSE" },
        { name: "COUNTY NEW BREEZE", value: "COUNTY NEW BREEZE"}
    ]

    errors = [
        { name: "Lỗi túi khí", value: 0},
        { name: "Lỗi động cơ", value: 1},
        { name: "Lỗi chân ga, chân phanh", value: 2},
        { name: "Lỗi hệ thống điều khiển", value: 3},
        { name: "Lỗi khác", value: 4},
    ]
}
