export interface ProductLine {
    id: number;
    name: string;
    description?: string;
    type: number;
    categoryCar: number;
    length: number;
    width: number;
    power: number;
    momentum: number;
    gearbox: number;
    seats: number;
    engine: string;
    imgUrl?: string;
    createdDate?: string;
    createdBy?: string;
    modifiedDate?: string;
    modifiedBy?: string;
}
