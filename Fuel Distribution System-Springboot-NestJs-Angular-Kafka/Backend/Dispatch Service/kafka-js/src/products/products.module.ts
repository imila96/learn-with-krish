
import { Module } from '@nestjs/common';
import { MongooseModule } from '@nestjs/mongoose';
import {ProductsController } from './products.controller';
import { ProductSchema } from './product.model';
import { ProductsService } from './products.service';
//import { ProductsController } from './products/products.controller';
//import { ProductsService } from './products/products.service';

@Module({

controllers:[ProductsController],
providers:[ProductsService],

})
export class ProductsModule {}
