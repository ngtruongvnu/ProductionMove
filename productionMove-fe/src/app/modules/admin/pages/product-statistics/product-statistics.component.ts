import {Component, OnInit} from '@angular/core';
import Chart from "chart.js/auto";
import {ProductService} from "../../services/product.service";

@Component({
    selector: 'app-product-statistics',
    templateUrl: './product-statistics.component.html',
    styleUrls: ['./product-statistics.component.less']
})
export class ProductStatisticsComponent implements OnInit {
    public chart: any = {};
    dataProductByStatus !: any;
    constructor(
        private productService: ProductService
    ) {
    }

    ngOnInit(): void {
        this.getProductByStatus();
    }

    /**
     * Get product by status
     * After get data, call createChart() to create chart
     */
    getProductByStatus() {
        this.productService.statisticProductByStatus().subscribe(data => {
            this.dataProductByStatus = data;
            this.createChartForStatisticByStatus(this.dataProductByStatus);
        });
    }

    /**
     * Create chart for statistic product by status
     * @param data : data from API
     */
    createChartForStatisticByStatus(data : any) {
        const dataLabel = Object.keys(data).filter(key => data[key] > 0);
        const dataValue = Object.values(data).filter((value) => {
            return (value as number) > 0
        });
        this.chart = new Chart("barChart", {
            type: 'bar',
            data: {// values on X-Axis
                labels: dataLabel,
                datasets: [
                    {
                        label: "Sản phẩm",
                        data: dataValue,
                        backgroundColor: "#3cba9f",
                    }
                ]
            },
            options: {
                aspectRatio:2.5,
                plugins: {
                    title: {
                        display: true,
                        text: 'Thống kê sản phẩm theo trạng thái'
                    }
                }
            }
        });
    }

}
