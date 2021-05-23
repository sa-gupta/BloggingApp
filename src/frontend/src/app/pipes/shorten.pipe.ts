import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'shorten'
})
export class ShortenPipe implements PipeTransform {

  transform(value: string, len:number=10): string {
    if(value.length>len){
      return value.substr(0,len)+"...";
    }
    return value;
  }

}
