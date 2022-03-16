'use strict';

class UserData {

    constructor(data){
        this.name = data[0];
        this.surrname = data[1];
        this.year_of_birth = data[2]; 
    }

    get_name(){
        return this.name;
    }
    get_surrname(){
        return this.surrname; 
    } 
    get_year_of_birth(){
        return this.year_of_birth; 
    } 
    
}

let dane = ['Grzegorz','Krzesiński','1999']
const show = new UserData(dane);

 console.log(`Imię: ` + show.get_name());
 console.log(`Nazwisko: ` + show.get_surrname());
 console.log(`Rok urodzenia: ` + show.get_year_of_birth());