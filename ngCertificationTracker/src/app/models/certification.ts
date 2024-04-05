import { User } from './user';

export class Certification {
  id: number;
  user: User;
  company: string;
  name: string;
  dateObtained: string;
  dateExpiration: string;

  constructor(
    id: number = 0,
    user: User = new User(),
    company: string = '',
    name: string = '',
    dateObtained: string = '',
    dateExpiration: string = ''
  ) {
    this.id = id;
    this.user = user;
    this.company = company;
    this.name = name;
    this.dateObtained = dateObtained;
    this.dateExpiration = dateExpiration;
  }
}
