import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sendback-to-agent',
  templateUrl: './sendback-to-agent.component.html',
  styleUrls: ['./sendback-to-agent.component.less']
})
export class SendbackToAgentComponent implements OnInit {
    selectedValue: any;

  constructor() { }

  ngOnInit(): void {
  }

}
