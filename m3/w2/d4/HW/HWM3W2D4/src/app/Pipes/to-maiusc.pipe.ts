import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'toMaiusc'
})
export class ToMaiuscPipe implements PipeTransform {

  transform(value: string, ...args: string[]): string {
    return value.toUpperCase();
  }

}
