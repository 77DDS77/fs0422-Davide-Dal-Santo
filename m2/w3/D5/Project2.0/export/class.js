

export class User {
    constructor(username, firstName, lastName, gender, profileURL, email, id) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.profileURL = profileURL;
        this.email = email;
        this.id = id;

        this.showUser()
    }

    showUser() {

        this.cloneAcc();

        this.accTitle();

        this.accButton();

        this.collapse();

        this.accordionBody();


    }

    //cloning the original accordion
    cloneAcc() {
        let accContainer = document.querySelector('#myUsers');

        let originalAcc = document.querySelector('.accordion-item');
        
        let cloneAcc = originalAcc.cloneNode(true);

        cloneAcc.id = 'user_' + this.username;

        accContainer.appendChild(cloneAcc);
    }

    // ID change for tag h2
    accTitle() {
        
        let cloneaAccTitle = document.querySelector('#user_' + this.username + ' .accordion-header')

        cloneaAccTitle.id = this.username + 'Accordion'
    }

    accButton() {
        // content of accordion button
        let cloneAccBtn = document.querySelector('#user_' + this.username + ' .accordion-header' + ' button');

        cloneAccBtn.textContent = `${this.firstName} ${this.lastName}`

        //setting attribute bs-target for localized collapse
        cloneAccBtn.setAttribute('data-bs-target', '#collapse-' + this.username)
    }


    //setting the collapse ID and attribute
    collapse() {
        
        let cloneAccCollapse = document.querySelector('#user_' + this.username + ' #utente-userID')

        cloneAccCollapse.id = 'collapse-' + this.username

        cloneAccCollapse.setAttribute('aria-labelledby', 'user_' + this.username)
    }


    //setting the accordion body content
    accordionBody() {
       
        let cloneAccBody = document.querySelector('#collapse-' + this.username + ' .accordion-body')

        for (let prop in this) {
            if (prop != 'username' && prop != 'profileURL' && prop != 'id') {

                //creating the paragraph to show the prop
                let p = document.createElement('p')
                //creating the span to highlight the prop name
                let span = document.createElement('span')
                span.textContent = prop + ': '
                span.className = 'propSpan text-primary'
                //setting the paragraph content
                p.className = this.username + '-' + prop
                p.textContent = this[prop]
                
                p.prepend(span)
                cloneAccBody.appendChild(p)

            }else if(prop == 'profileURL'){
                //creating a p with an img tag inside for the "profile pic"
                let p = document.createElement('p')
                p.className = this.username + '-' + prop
                
                let img = document.createElement('img')
                img.src = this[prop]
                img.className = 'user-img'
                p.append(img)
                 
                cloneAccBody.appendChild(p)
            }
        }
        
        //creating update e delete btn
        let updateBTN = document.createElement('a')
        updateBTN.textContent = 'Modifica';
        updateBTN.className = 'btn btn-warning'
        updateBTN.href = 'modifica.html?user='+ this.id;
        let deleteBTN = document.createElement('a')
        deleteBTN.textContent = 'Cancella';
        deleteBTN.className = 'btn btn-danger ms-2'

        //delete button event
        deleteBTN.addEventListener('click', () =>{
            eliminaUtente(this.id, this.cloneAcc)
        })

        cloneAccBody.append(updateBTN, deleteBTN)
    }
}