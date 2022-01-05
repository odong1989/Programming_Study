//
//  ContentView.swift
//  ListExample1
//
//  Created by 김보성 on 2022/01/05.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        return List(0..<10){item in
            Text("\(item)")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
