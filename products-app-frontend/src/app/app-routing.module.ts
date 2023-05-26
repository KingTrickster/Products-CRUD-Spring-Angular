import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowProductsComponent } from './show-products/show-products.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ReadProductComponent } from './read-product/read-product.component';


const routes: Routes = [

  { path: '', redirectTo: 'product', pathMatch: 'full' },
  { path: 'products', component: ShowProductsComponent },
  { path: 'add', component: CreateProductComponent },
  { path: 'update', component: UpdateProductComponent },
  { path: 'details/:id', component: ReadProductComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
