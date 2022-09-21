import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { KafkaModule } from './kafka/kafka.module';
import { TestConsumer } from './test.consumer';
import { MongooseModule } from '@nestjs/mongoose';

import { ProductsController } from './products/products.controller';
import { ProductsService } from './products/products.service';
import { ProductsModule } from './products/products.module';
import { ProductSchema } from './products/product.model';


@Module({
  imports: [KafkaModule, MongooseModule.forRoot('mongodb+srv://imila96:12345@cluster0.9vuprjs.mongodb.net/nestjs-demo?retryWrites=true&w=majority'),
  MongooseModule.forFeature([{ name: 'Product', schema: ProductSchema }]), ],
  controllers: [AppController,ProductsController],
  providers: [AppService, TestConsumer,ProductsService],
})
export class AppModule {}