import { render, screen } from '@testing-library/react';
import App from './App';
import Cod from './Components/Account';
import Footer from './Components/Footer';
import Header from './Components/Header';
import Cate from './Components/Categories';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});

test('Render del form Login', () => {
  render(<Footer />);
  const formL = screen.getByRole('article',{name: 'formLogin'});
  expect(formL).toBeInTheDocument();
});


test('Render del form Login', () => {
  render(<Header />);
  const formL = screen.getByRole('article',{name: 'formLogin'});
  expect(formL).toBeInTheDocument();
});

test('Render del form Login', () => {
  render(<Cate />);
  const formL = screen.getByRole('article',{name: 'formLogin'});
  expect(formL).toBeInTheDocument();
});


describe('Test complete', () => {

  test('Render del form Login', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del form Register', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render de la NavBAr', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Home', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Categories', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Buttons', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Styles From Login', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Styles From Register', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Styles Buttons', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Styles Home', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Styles NavBAr', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Functions Form Login', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Functions Form Register', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Functions Home', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Functions Categories', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Functions NavBAr', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });
  test('Render del Header', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });
  test('Render del Styles Header', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });
  test('Render del Funtion Header', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });
  test('Render del Name User Correct', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });
  test('Render del Footer', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });
  test('Render del Styles Footer', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

  test('Render del Funciton Footer', () => {
    render(<Cod />);
    const formL = screen.getByRole('article',{name: 'formLogin'});
    expect(formL).toBeInTheDocument();
  });

})