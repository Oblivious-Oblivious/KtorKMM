import SwiftUI;
import shared;

struct ContentView: View {
    @ObservedObject var viewmodel: ViewModel;

    var body: some View {
        List {
            ForEach(viewmodel.works, id: \.self) { work in
                Text("\(work.name) (\(work.year)), \(work.creator)");
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(viewmodel: ViewModel());
	}
}
