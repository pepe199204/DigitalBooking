import { render, screen } from '@testing-library/react';
import Home from '../App';

describe('Home test', () => {
    test('Render del Home', () => {
        render(<Home />);
        const homeR = screen.getByText(/Home rut exist/i);
        expect(homeR).toBeInTheDocument();
    });

    test('Render del Singin', () => {
        render(<Home />);
        const homeS = screen.getByText(/Singin rut exist/i);
        expect(homeS).toBeInTheDocument();
    });

    test('Render del Login', () => {
        render(<Home />);
        const homeL = screen.getByText(/Login rut exist/i);
        expect(homeL).toBeInTheDocument();
    });

    test('Render del Producto', () => {
        render(<Home />);
        const homeP = screen.getByText(/Producto rut exist/i);
        expect(homeP).toBeInTheDocument();
    });
});