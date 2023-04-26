import { render, screen } from '@testing-library/react';
import Account from '../Components/Account';

describe('Account test', () => {
    test('Render de Account', () => {
        render(<Account />);
        const account = screen.getByText(/Account exist/i);
        expect(account).toBeInTheDocument();
    });

    test('Styles Account', () => {
        render(<Account />);
        const account = screen.getByText(/Account styles/i);
        expect(account).toHaveStyle({
            display: flex,
            alignitems: center,
            flexdirection: column,
            backgroundcolor: rgba(196, 196, 196, 0.1) ,
            height: 100
        });
    });

    test('Componentes de Account', () => {
        render(<Account />);
        const formPersona = screen.getByText(/Account exist/i);
        const labelNom = screen.getByRole('label','label nombre');
        const inputNom = screen.getByRole('input','input nombre');
        const labelApe = screen.getByRole('label','label apellido');
        const inputApe = screen.getByRole('input','input apellido');
        const labelEmail = screen.getByRole('label','label email');
        const inputEmail = screen.getByRole('input','input email');
        const labelContra = screen.getByRole('label','label password');
        const inputContra = screen.getByRole('input','input password');
        const labelContra2 = screen.getByRole('label','label password2');
        const inputContra2 = screen.getByRole9('input','input password2');
        expect(formPersona).toBeInTheDocument();
        expect(labelNom).toBeInTheDocument();
        expect(inputNom).toBeInTheDocument();
        expect(labelApe).toBeInTheDocument();
        expect(inputApe).toBeInTheDocument();
        expect(labelEmail).toBeInTheDocument();
        expect(inputEmail).toBeInTheDocument();
        expect(labelContra).toBeInTheDocument();
        expect(inputContra).toBeInTheDocument();
        expect(labelContra2).toBeInTheDocument();
        expect(inputContra2).toBeInTheDocument();
    });

});