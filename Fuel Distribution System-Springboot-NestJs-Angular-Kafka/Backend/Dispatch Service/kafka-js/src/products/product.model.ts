import * as mongoose from 'mongoose';

export const ProductSchema = new mongoose.Schema({

  _id: String,
    orderId: String,
  //  fuelType: String,
  //  qty:Number,
    status:String,
    date: Date


});


export interface Product extends mongoose.Document {
  
  _id: string,
    orderId: string,
   // fuelType: string,
   // qty:number,
    status:string,
    date: Date
   

}