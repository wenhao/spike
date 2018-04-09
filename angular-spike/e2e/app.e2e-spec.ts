import { AngularSpikePage } from './app.po';

describe('angular-spike App', () => {
  let page: AngularSpikePage;

  beforeEach(() => {
    page = new AngularSpikePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
