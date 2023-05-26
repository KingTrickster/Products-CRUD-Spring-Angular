import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }

  getProduct(id: string): Observable<any> {
    return this.http.get(this.baseUrl + '/products/'+id);
  }

  createProduct(product: Object): Observable<Object> {
    return this.http.post(this.baseUrl + '/products/', product);
  }

  updateProduct(product: Object): Observable<Object> {
    return this.http.put(this.baseUrl + '/products/', product);
  }

  deleteProduct(id: string): Observable<any> {
    return this.http.delete(this.baseUrl + '/products/'+id);
  }

  getProductsList(): Observable<any> {
    return this.http.get(this.baseUrl+'/products/');
  }
}

