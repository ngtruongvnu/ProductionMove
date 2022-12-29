export interface User {
    id: number;
    username: string;
    role: number;
    imgUrl?: string;
    firstName: string;
    lastName: string;
    createdDate?: string;
    createdBy?: string;
    modifiedDate?: string;
    modifiedBy?: string;
}
