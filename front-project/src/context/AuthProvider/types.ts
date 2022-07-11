export interface IUser {
    email?: string;
    token?:string;
}

export interface IContext extends IUser {
     authenticate: (email: string, senha: string ) => Promise <void>;
     logout: () => void;

}

export interface IAuthProvider {
    children: JSX.Element;
}

export interface Ilancamentos {
    id?: string;
    data?: string;
    descricao?: string;
    valor?: string;
    tipolancamento?:string;
}

export interface IPaginacao <T> {
    content?: any;
    last?: Boolean;
    first?: Boolean;
    totalPages?: number;
    number?: number;
}