import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NitryxTestComponent } from './nitryx-test/nitryx-test.component';

const routes: Routes = [
  {
    path: '',
    component: NitryxTestComponent,
    data: { title: "Nitryx Test" }
  },
];

@NgModule({
  declarations: [NitryxTestComponent],
  imports: [
    RouterModule.forChild(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class PagesModule { }
