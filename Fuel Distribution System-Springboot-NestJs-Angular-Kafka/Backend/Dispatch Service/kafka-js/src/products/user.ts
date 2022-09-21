

export class Order {
   
    
   
    static qty:number
    static status:string
    static  date: Date
    static orderId: string
    static fuelType: string


//setters
   
    static setFuelType(x: string) {
        this.fuelType=x;
    }
    static setOrderId(x: string) {
        this.orderId=x;
    }
    static setQty(x: number) {
        this.qty=x;
    }
    static setStatus(x: string) {
        this.status=x;
    }
    static setDate(x: Date) {
        this.date=x;
    }

    //getterrs

    static getOrderId(): string {
        return this.orderId;
    }
    static getFuelType(): string {
        return this.fuelType;
    }
    static getQty(): number {
        return this.qty;
    }
    static getStatus(): string {
        return this.status;
    }
    static getDate(): Date {
        return this.date;
    }

   // static insert(): Function {
        
    //   return sc.run;
 //  }
   

}
    
