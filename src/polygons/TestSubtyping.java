package polygons;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSubtyping extends JComponent {

        public static void main(String[] args) {
                JFrame frame = new JFrame();
                Graphics g = frame.getGraphics();
                testSubtyping(g);
        }

        public static void testSubtyping(Graphics g) {
                // Step 0a: Look at these six variables, and their
                // static (declared) types. We're going to test them
                // in various ways, so remember what the static types are.
                Polygon[] polyArray = new Polygon[10];
                Triangle[] triArray = new Triangle[10];

                List<Polygon> polyList = new ArrayList<>();
                List<Triangle> triList = new ArrayList<>();

                List<? extends Polygon> coPolyList = new ArrayList<>();
                List<? super Polygon> contraPolyList = new ArrayList<>();

                // Step 0b: Look at these four variables, and their
                // static (declared) types AND dynamic types. We're going
                // to use them to test the collections above.
                Object obj = new Object();
                Polygon pol = new Triangle(1, 1);
                Triangle tri = new Triangle(2, 2);
                Square squ = new Square(3, 3);

                // Step 1a: Predict what the results of these lines will be.
                // Will they work? Will they lead to a static type error?
                // Will they cause a dynamic (runtime) error (i.e. an exception)?
                // If they cause an error, why? // OK/Static error/Dynamic error
                // polyArray[0] = pol; // OK
                // polyArray[1] = tri; // OK
                // triArray[0] = pol; // Static error
                // triArray[1] = tri; // OK
                // triArray[2] = (Triangle) pol; // OK
                //
                // polyList.add(pol); // OK
                // polyList.add(tri); // OK
                // triList.add(pol); // Static error
                // triList.add(tri); // OK
                // triList.add((Triangle) pol); // OK
                // triList.add((Triangle) obj); // Dynamic error
                // you can never add anything (except) null to lists <? extends T> but
                // anything taken from list is guaranteed to be of type T
                // coPolyList.add(pol); // Static error
                // coPolyList.add(tri); // Static error
                // coPolyList.add(obj); // Static error
                // you can always add T to a list <? super T>
                // including any subtype of T, since they are also a type of T
                // contraPolyList.add(pol); // OK
                // contraPolyList.add(tri); // OK
                // contraPolyList.add(obj); // Static error, obj is not (statically) of type
                // Polygon

                // Step 1b: Predict what the results of these lines will be.
                // Will they work? Will they lead to a static type error?
                // Will they cause a dynamic (runtime) error (i.e. an exception)?
                // If they cause an error, why?
                // Then, uncomment them and run. Were your answers correct?
                // OK/Static error/Dynamic error
                // obj = polyList.get(0); // OK
                // pol = polyList.get(0); // OK
                // tri = polyList.get(0); // Static error
                // tri = (Triangle) polyList.get(0); // OK
                // pol = triList.get(0); // OK
                // tri = triList.get(0); // OK
                //
                // pol = coPolyList.get(0); // OK // dynamic error, copoly has no entries
                // tri = coPolyList.get(0); // Static error
                // pol = contraPolyList.get(0); // Static error
                // tri = contraPolyList.get(0); // Static error
                // obj = contraPolyList.get(0); // OK, can get an object?

                // Step 1c: Predict what the results of these lines will be.
                // Will they work? Will they lead to a static type error?
                // Will they cause a dynamic (runtime) error (i.e. an exception)?
                // If they cause an error, why?
                // Then, uncomment them and run. Were your answers correct?
                // OK/Static error/Dynamic error
                // triArray = (Triangle[]) polyArray; // Dynamic error
                // polyArray = triArray; // OK
                // triArray = polyArray; // Static error
                // triArray = (Triangle[]) polyArray; // Ok if polyArray = triArray run
                //
                // triList = polyList; // Static error
                // polyList = triList; // Static error
                // polyList = (List<Triangle>) triList; // static error
                //
                // coPolyList = polyList; // OK
                // coPolyList = triList; // OK
                // polyList = coPolyList; // Static error
                // triList = coPolyList; // Static error
                //
                // contraPolyList = polyList; // OK
                // contraPolyList = triList; // Static error
                // polyList = contraPolyList; // Static error
                // triList = contraPolyList; // Static error
                //
                // coPolyList = contraPolyList; // Static error
                // contraPolyList = coPolyList; // Static error
                //
                for (Polygon p : coPolyList) {
                        contraPolyList.add(p); // OK
                }

                // Step 2a: Predict what the results of these lines will be.
                // Will they work, or will they lead to a static type error?
                // Then, uncomment them add check. Were your answers correct?
                // paintAll(g, polyList); // OK                 // dynamic error g null
                // paintAll(g, triList); // Static error // 2b  // dynamic error g null
                // Step 2b: There's no reason why 'paintAll' shouldn't
                // work for both lists. Can you change the parameter type
                // for 'polygons' in the declaration of 'paintAll' below,
                // so that it works for both cases above?

                // Step 3a: Predict what the results of these lines will be.
                // Will they work, or will they lead to a static type error?
                // Then, uncomment them add check. Were your answers correct?
                // addAll(polyList, polyList); // OK   // Dynamic error, concurrentModificationException
                // addAll(triList, polyList); // Error // 3b
                // addAll(polyList, triList); // Error // should be error
                // addAll(triList, triList); // Error // should be ok?
                // Step 3b: Can you change the parameter types for 'from'
                // and 'to' in the declaration of 'addAll' below, to make it
                // work for three out of four cases above?
                // Why can you not make it work for the fourth?
                // (Hint: it's for a good reason.)

                final Polygon polygon = pol;
                // Step 4: Look up the types of the three following methods
                // from Java's standard libraries (hover over the method names
                // in IntelliJ, don't mind the warnings).
                // Can you explain why they have the declared types they do?
                // polyList.addAll(triList); // What is the parameter type of addAll? Collection<? extends Polygon>
                // boolean b = polyList.containsAll(triList); // What is the parameter type of containsAll? Collection<?>
                // polyList.removeIf(p -> p.equals(polygon)); // What is the parameter type of removeIf? Predicate<? super Polygon>

                // Step 5: Predict what the results of these lines will be.
                // Will they work? Will they lead to a static type error?
                // Will they cause a dynamic (runtime) error (i.e. an exception)?
                // If they cause an error, why?
                // Then, uncomment them and run. Were your answers correct?
                // polyArray = triArray; // OK
                // polyArray[0] = squ; // OK// dynamic error after setting polyArray = triArray
                // tri = triArray[0]; // OK
                //
                // polyList = triList; // Static error
                // polyList.add(0, squ); // OK
                // tri = triList.get(0); // OK

        }

        // Step 2b: Change the parameter type of 'polygons' to
        // the broadest (most general) type possible with respect
        // to how it is used in the method body.
        public static void paintAll(Graphics g, List<? extends Polygon> polygons) {
                for (Polygon p : polygons)
                        p.paint(g);
        }

        // Step 3d: Change the parameter types of 'from' and 'to' to
        // the broadest (most general) types possible, given how they
        // are used respectively in the method body.
        public static void addAll(List<? extends Polygon> from, List<? super Polygon> to) {
                for (Polygon p : from)
                        to.add(p);
        }

}
