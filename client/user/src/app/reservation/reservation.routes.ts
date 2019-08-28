import { NgModule } from "@angular/core";
import {RouterModule, Routes} from '@angular/router';
import { ShopInfoComponent } from "./shop-info/shop-info.component";

const routes: Routes = [
    { path: 'store/:id',  component:ShopInfoComponent } 
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
    declarations: []
})
export class ReservationRoutingModule{
}
