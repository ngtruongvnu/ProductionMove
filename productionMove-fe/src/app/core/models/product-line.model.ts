export interface ProductLine {
    id: number;
    name: string;
    description?: string;
    type: number;
    categoryCar: number;
    lenght: number;
    width: number;
    power: string;
    displacement: number;
    gearbox: number;
    seats: number;
    engine: string;
    imgUrl?: string;
    createdDate?: string;
    createdBy?: string;
    modifiedDate?: string;
    modifiedBy?: string;
}
