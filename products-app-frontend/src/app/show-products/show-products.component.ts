import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Observable } from 'rxjs';
import { Product } from '../model/product';
import { Router } from '@angular/router';
@Component({
  selector: 'app-show-products',
  templateUrl: './show-products.component.html',
  styleUrls: ['./show-products.component.css']
})
export class ShowProductsComponent implements OnInit {

  products: Observable<Product[]>;

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit() {
    this.fetchProductList();
  }

  fetchProductList() {
    this.products = this.productService.getProductsList();
  }

  deleteProduct(id: string) {
    this.productService.deleteProduct(id)
      .subscribe(
        data => {
          console.log(data);
          this.fetchProductList();
        },
        error => console.log(error));
  }

  productDetails(id: string) {
    this.router.navigate(['details', id]);
  }

  updateProduct(product: Product){
    this.router.navigate(['update', product]);
  }
}
