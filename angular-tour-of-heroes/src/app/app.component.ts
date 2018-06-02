import {Component} from '@angular/core';

export class Hero {
  id: number;
  name: string;
}

const HEROS: Hero[] = [
  { id: 11, name: 'Mr. Nice'},
  { id: 12, name: 'Narco' },
  { id: 13, name: 'Bombasto' },
  { id: 14, name: 'Celeritas' },
  { id: 15, name: 'Magneta' },
  { id: 16, name: 'RubberMan' },
  { id: 17, name: 'Dynama' },
  { id: 18, name: 'Dr IQ' },
  { id: 19, name: 'Magma' },
  { id: 20, name: 'Tornado' }
];

@Component({
  selector: 'app-root',
  // templateUrl: './app.component.html',
  template: `
    <h1>{{title}}</h1>
    <h2>My Heros</h2>
    <ul class="heros">
      <li *ngFor="let hero of heros" (click)="onSelect(hero)">
        <span class="badge">{{hero.id}}</span>{{hero.name}}
      </li>
    </ul>
  `,
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'app';
  heros = HEROS;
  selectedHero: Hero;
}
