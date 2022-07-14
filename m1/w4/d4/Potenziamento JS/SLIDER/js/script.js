let left = 0;

function move(){

    let allSlides = document.querySelectorAll('#slider .wrapper img')
    let firstSlideWidth = allSlides[0].clientWidth;
    let sliderWidth = document.querySelector('#slider').clientWidth;
    let space = Math.trunc(sliderWidth / firstSlideWidth) * firstSlideWidth;

    let wrapper = document.querySelector('#slider .wrapper');
    console.log(space);

    if(left < allSlides.length * firstSlideWidth - space){
        left += space;
    }else{
        left = 0;
    };
    

    wrapper.style.marginLeft = - left + 'px';

}
function moveRight(){

    let allSlides = document.querySelectorAll('#slider .wrapper img')
    let firstSlideWidth = allSlides[0].clientWidth;
    let sliderWidth = document.querySelector('#slider').clientWidth;
    let space = Math.trunc(sliderWidth / firstSlideWidth) * firstSlideWidth;

    let wrapper = document.querySelector('#slider .wrapper');
    console.log(space);

    if(left > 0 ){
        left -= space;
    }else{
        left = allSlides.length * firstSlideWidth - space;
    };
    

    wrapper.style.marginLeft = - left + 'px';

}