import { Order } from 'src/model/order.service';
import {
    Controller,
    Post,
    Body,
    Get,
    Param,
    Patch,
    Delete,
  } from '@nestjs/common';
  
  import { ProductsService } from './products.service';

  
  @Controller('products')
  export class ProductsController {
    constructor(private readonly productsService: ProductsService) {}

  

    @Post()
    async addProduct(


      @Body('_id')_id: string,
      @Body('orderId')orderId: string,
      @Body('status') status: string,
      @Body('date') date: Date
    ) {
      const generatedId = await this.productsService.insertProduct(
        _id,
       orderId,
        status,
        date,
      );
      return { id: generatedId };
    }
  
    @Get()
    async getAllProducts() {
      const products = await this.productsService.getProducts();
      return products;
    }
  
    @Get(':_id')
    getProduct(@Param('_id') _id: string) {
      return this.productsService.getSingleProduct(_id);
    }
  
    @Patch(':_id')
    async updateProduct(

      @Param('_id')_id: string,
      @Param('orderId')orderId: string,
      @Body('status') status: string,
      @Body('date') date: Date,
    ) {
      await this.productsService.updateProduct(_id,orderId, status, date);
      return null;
    }

    /*
  
    @Delete(':id')
    async removeProduct(@Param('id') prodId: string) {
        await this.productsService.deleteProduct(prodId);
        return null;
    }
    */
  }