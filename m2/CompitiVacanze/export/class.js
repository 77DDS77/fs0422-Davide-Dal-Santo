

//defining the comment Object
export class Comment {
    constructor(id, name, date, comment, fullDate){
        this.id = id;
        this.name = name;
        this.date = date;
        this.comment = comment;
        this.fullDate = fullDate;

        this.createCommentCard();
    }

    createCommentCard(){
        this.cloneCard();
        this.writeHeader();
        this.writeBody();
    }

    cloneCard(){
        let cardOriginal = document.querySelector('.card')
        let cardClone = cardOriginal.cloneNode(true);
        cardClone.id = `comment-${this.id}`

        let cardContainer = document.querySelector('#card-container')
        cardContainer.prepend(cardClone)
    }

    writeHeader(){
        let cloneHeader = document.querySelector(`#comment-${this.id} .card-header`)
        let cloneName = cloneHeader.querySelector('.header-name');
        let cloneDate = cloneHeader.querySelector('.header-date');
        
        cloneName.textContent = this.name
        cloneDate.textContent = this.date
    }

    writeBody(){
        let cloneBody = document.querySelector(`#comment-${this.id} .card-body`)
        let bodyContent = cloneBody.querySelector('.comment-content');
        
        bodyContent.textContent = this.comment;
    }
}