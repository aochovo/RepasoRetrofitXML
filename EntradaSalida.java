/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasoaccesodatosretrofit;

import java.util.Scanner;

/**
 *
 * @author alex
 */
public class EntradaSalida {
    public static int pedirCodigo()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Que codigo es??????");
        int codigo_provincia=sc.nextInt();
        return codigo_provincia;
    }
            
}
