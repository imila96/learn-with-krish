import { Injectable, NotFoundException } from '@nestjs/common';
import { Product } from './product.model';
import { InjectModel} from '@nestjs/mongoose';
import { Model} from 'mongoose';
import { Order } from 'src/model/order.service';

@Injectable()
export class ProductsService {

    private products: Product[] = [];

   static x : string;
  static porderId: string;
  static pstatus: string;
  static pdate: Date;

//   public static sendp(_id: string,orderId: string, status:string, date:Date) {
      
// this.insertProduct(_id,orderId,status,date);

//   }

    constructor(@InjectModel('Product')private readonly productModel:Model<Product>){}

    
    

    async insertProduct( _id: string,orderId: string, status:string, date:Date )
    {

            const newProduct =new this.productModel({
              _id :ProductsService.porderId,
            orderId : ProductsService.porderId,
            status : ProductsService.pstatus,
            date : ProductsService.pdate

           

            });
           const result=await  newProduct.save();
           
            console.log(result);
            return result.id as string;


    }
    async getProducts() {
      const products = await this.productModel.find().exec();
      return products.map(prod => ({
        _id:prod.orderId,
        orderId:prod.orderId,
        status: prod.status,
        date:prod.date
      }));
    }
    async getSingleProduct(_id: string) {
      const product = await this.findProduct(_id);
      return {
        _id:product.orderId,
          orderId:product.orderId,
          status: product.status,
          date:product.date
      };
    }

    private async findProduct(orderId: string): Promise<Product> {
      let product;
      try {
        product = await this.productModel.findById(orderId).exec();
      } catch (error) {
        throw new NotFoundException('Could not find product.');
      }
      if (!product) {
        throw new NotFoundException('Could not find product.');
      }
      return product;
    }

    async updateProduct(
      
      _id:string,
      orderId: string,
      status: string,
      date: Date,
    ) {
      const updatedProduct = await this.findProduct(_id);

      if (_id) {
        updatedProduct._id = _id;
      }
      if (orderId) {
        updatedProduct.orderId = orderId;
      }
      if (status) {
        updatedProduct.status = status;
      }
      if (date) {
        updatedProduct.date = date;
      }
      updatedProduct.save();
    }


}
