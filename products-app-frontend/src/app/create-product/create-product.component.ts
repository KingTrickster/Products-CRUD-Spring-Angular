import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { Product } from '../model/product';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  submitted = false;

  constructor(private productService: ProductService, private router: Router) { }

  product: Product = new Product();

  ngOnInit() {
  }

  saveProduct() {
    this.productService.createProduct(this.product)
      .subscribe(data => console.log(data), error => console.log(error));
    this.product = new Product();
    this.gotoProductList();
  }

  onSubmit() {
    this.saveProduct();
    this.submitted = true;
  }

  gotoProductList() {
    this.router.navigate(['/products']);
  }

}
