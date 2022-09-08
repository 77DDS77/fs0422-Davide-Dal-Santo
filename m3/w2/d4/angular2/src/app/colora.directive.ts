import { Directive, ElementRef, HostListener, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appColora]'
})
export class ColoraDirective {

  constructor(
    private ref:ElementRef,
    private renderer:Renderer2
  ) { }

  @Input() color:string = 'red'; //abilita un attributo
  @Input('appColora') fz:string = '1rem'; //abilita un attributo

  @HostListener('click') onClick(){
    this.color = 'blue';
    this.renderer.setStyle(this.ref.nativeElement, 'color', this.color)

  }
  @HostListener('mouseenter') onMouseEnter(){
    this.color = 'green';
    this.renderer.setStyle(this.ref.nativeElement, 'color', this.color)

  }
  @HostListener('mouseout') onMouseLeave(){
    this.color = 'red';
    this.renderer.setStyle(this.ref.nativeElement, 'color', this.color)

  }

  ngOnInit() {
    //this.ref.nativeElement.style.color = 'red';
    this.renderer.setStyle(this.ref.nativeElement, 'color', this.color)
    this.renderer.setStyle(this.ref.nativeElement, 'font-size', this.fz)
    this.renderer.setAttribute(this.ref.nativeElement, 'data-bs-target', 'test')
  }

}

/**
 *
 * ref:ELementRef e' il tag su cui attacchiamo la
 * direttiva
 *
 *
 */
