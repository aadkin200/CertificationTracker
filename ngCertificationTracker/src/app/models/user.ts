import { Certification } from './certification';

export class User {
  id: number;
  username: string;
  password: string;
  email: string;
  firstName: string;
  lastName: string;
  admin: boolean;
  createdAt: string;
  updatedAt: string;
  certifications: Certification[];
  active: boolean;
  role: string;

  constructor(
    id: number = 0,
    username: string = '',
    password: string = '',
    email: string = '',
    firstName: string = '',
    lastName: string = '',
    admin: boolean = false,
    createdAt: string = '',
    updatedAt: string = '',
    certifications: Certification[] = [],
    active: boolean = false,
    role: string = ''
  ) {
    (this.id = id),
      (this.username = username),
      (this.password = password),
      (this.email = email),
      (this.firstName = firstName),
      (this.lastName = lastName),
      (this.admin = admin),
      (this.createdAt = createdAt),
      (this.updatedAt = updatedAt),
      (this.certifications = certifications),
      (this.active = active),
      (this.role = role);
  }
}
