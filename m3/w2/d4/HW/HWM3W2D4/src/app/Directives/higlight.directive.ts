import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appHiglight]'
})
export class HiglightDirective {

  constructor(
    private ref:ElementRef,
    private renderer:Renderer2
  ) { }

  ngOnInit() {
    this.renderer.setStyle(this.ref.nativeElement, 'background-color', '#FBF719')

  }


}
