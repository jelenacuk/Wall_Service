export class NewPostDto {

    text: string;
    creationDate: Date;

    constructor(text: string, creationDate: Date) {
        this.text = text;
        this.creationDate = creationDate;
    }
}
