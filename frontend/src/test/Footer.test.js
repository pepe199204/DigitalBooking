import { render, screen } from '@testing-library/react';
import Footer from '../Components/Footer';

describe('Footer test', () => {
    test('Render del Footer', () => {
        render(<Footer />);
        const footer = screen.getByText(/Footer exist/i);
        expect(footer).toBeInTheDocument();
    });

    test('Styles del footer', () => {
        render(<Footer />);
        const footer = screen.getByRole('footer','style footer');
        expect(footer).toHaveStyle({
            backgroundColor: $first-color,
            display: flex, 
            position: fixed,
            left: 0,
            width: 100,
            bottom: 0
        });
    });

    test('Componentes del footer', () => {
        render(<Footer />);
        const h3 = screen.getByRole('h3','©2023 Digital Booking');
        const a1 = screen.getByRole('a','a1');
        const a2 = screen.getByRole('a','a2');
        const a3 = screen.getByRole('a','a3');
        const a4 = screen.getByRole('a','a4');
        expect(h3).toBeInTheDocument();
        expect(a1).toBeInTheDocument();
        expect(a2).toBeInTheDocument();
        expect(a3).toBeInTheDocument();
        expect(a4).toBeInTheDocument();
    })
});
